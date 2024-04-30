# Summary

This is a task of lab4 from Documentation and design patterns. The task is to implement strategy for log output of reading a file. 

# Implementation

There is a config file `config` in this folder that determines the strategy. It can be 
either `kafka` or `console`. Startegy is hotswapped the moment you save the file.

# How to run

Create virtual environment and enter it:

```bash
python3.8 -m venv .venv
. .venv/bin/activate
```

Install dependencies:

```bash
pip install -r requirements.txt
```

Copy the file `data.csv` into your folder, an run the python script:

```bash
python file_reader.py
```

In the other terminal, Run kafka server:

```bash
docker-compose up -d
```

# View the data

Install kafka on your machine, and run

```bash
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic file_lines --from-beginning
```

You'll see the stream of logs once you select `kafka` int he config file

# Stop it

Kill docker:

```bash
docker-compose down
```

And kill the running script.