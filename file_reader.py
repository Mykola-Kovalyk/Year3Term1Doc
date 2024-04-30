import asyncio
import os
from abc import ABC, abstractmethod
from kafka import KafkaProducer
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler

class Sink(ABC):
    @abstractmethod
    async def write(self, line):
        pass

class ConsoleSink(Sink):
    async def write(self, line):
        print(line)

class KafkaSink(Sink):
    def __init__(self, bootstrap_servers, topic):
        self.producer = KafkaProducer(bootstrap_servers=bootstrap_servers)
        self.topic = topic

    async def write(self, line):
        await asyncio.get_running_loop().run_in_executor(None, self.producer.send, self.topic, line.encode('utf-8'))

class FileReader:
    def __init__(self, file_path, sink, delay=1):
        self.file_path = file_path
        self.sink = sink
        self.delay = delay

    def set_sink(self, sink):
        self.sink = sink

    async def read_file(self):
        with open(self.file_path, 'r') as file:
            for line in file:
                await self.sink.write(line.strip())
                await asyncio.sleep(self.delay)

class InputFileHandler(FileSystemEventHandler):
    def __init__(self, file_reader):
        self.file_reader = file_reader

    def on_modified(self, event):
        if event.src_path == './config':
            with open('./config', 'r') as file:
                sink_type = file.read().strip()
                if sink_type == 'console':
                    self.file_reader.set_sink(ConsoleSink())
                elif sink_type == 'kafka':
                    self.file_reader.set_sink(KafkaSink(['localhost:9092'], 'file_lines'))

async def main():
    console_sink = ConsoleSink()
    file_reader = FileReader('data.csv', console_sink, delay=1)

    # Create an observer to monitor the input file
    observer = Observer()
    observer.schedule(InputFileHandler(file_reader), '.', recursive=False)
    observer.start()

    while True:
        await file_reader.read_file()

if __name__ == '__main__':
    asyncio.run(main())