#!/usr/bin/env python3

"""
generates a random csv data for this schema

candidate:          id,userId,jobId
user:               id,name,phone,email
job_requisition:    id,jobDescription,location,requisitionManagerId
work_experience:    id,candidateId,company,position,startDate,endDate,description
education:          id,institution,degree,fieldOfStudy,graduationYear
skill:              id,candidateId,name,level
job_requirement:    id,jobId,type,description
recruiter:          id,department
social_profile:     id,platform,profileUrl
resume:             id

everything is generted in a single csv file. each table shall have a header row.
"""

import csv
import random
import string
from datetime import date, timedelta


def random_string(length):
    return "".join(random.choices(string.ascii_letters + string.digits, k=length))


def random_date(start_year, end_year):
    start = date(start_year, 1, 1)
    end = date(end_year, 12, 31)
    return (start + (end - start) * random.random()).strftime("%Y-%m-%d")


def random_name():
    first_names = [
        "John",
        "Jane",
        "Alice",
        "Bob",
        "Charlie",
        "David",
        "Eve",
        "Frank",
        "Grace",
        "Henry",
    ]
    last_names = [
        "Smith",
        "Johnson",
        "Williams",
        "Jones",
        "Brown",
        "Davis",
        "Miller",
        "Wilson",
        "Moore",
        "Taylor",
    ]
    return f"{random.choice(first_names)} {random.choice(last_names)}"


def random_phone():
    return f"{random.randint(100, 999)}-{random.randint(100, 999)}-{random.randint(1000, 9999)}"


def generate_email(name):
    name_parts = "".join(name.lower().split())
    domain = random.choice(
        ["gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "icloud.com"]
    )
    return f"{name_parts}@{domain}"


def generate_candidates(num_candidates):
    candidates = []
    for i in range(num_candidates):
        candidate = {
            "id": i + 1,
            "userId": random.randint(1, num_users),
            "jobId": random.randint(1, num_jobs),
        }
        candidates.append(candidate)
    return candidates


def generate_users(num_users):
    users = []
    for i in range(num_users):
        name = random_name()
        user = {
            "id": i + 1,
            "name": name,
            "phone": random_phone(),
            "email": generate_email(name),
        }
        users.append(user)
    return users


def generate_job_requisitions(num_jobs):
    job_requisitions = []
    for i in range(num_jobs):
        job_requisition = {
            "id": i + 1,
            "jobDescription": random_string(20),
            "location": random_string(10),
            "requisitionManagerId": random.randint(1, num_recruiters),
        }
        job_requisitions.append(job_requisition)
    return job_requisitions


def generate_work_experiences(num_work_experiences):
    work_experiences = []
    for i in range(num_work_experiences):
        work_experience = {
            "id": i + 1,
            "candidateId": random.randint(1, num_candidates),
            "company": random.choice(
                ["Google", "Microsoft", "Apple", "Amazon", "Facebook", "Twitter"]
            ),
            "position": random.choice(
                [
                    "Software Engineer",
                    "Data Scientist",
                    "Product Manager",
                    "QA Engineer",
                    "DevOps Engineer",
                ]
            ),
            "startDate": random_date(1980, 2023),
            "endDate": random_date(1980, 2023),
            "description": random_string(30),
        }
        work_experiences.append(work_experience)
    return work_experiences


def generate_educations(num_educations):
    educations = []
    for i in range(num_educations):
        education = {
            "id": i + 1,
            "candidateId": random.randint(1, num_candidates),
            "institution": random.choice(["LNU", "UCU", "KPI", "NULP", "KNU", "KN"]),
            "degree": random.choice(["Bachelor", "Master", "PhD"]),
            "fieldOfStudy": random.choice(
                ["Computer Science", "Mathematics", "Physics", "Chemistry", "Biology"]
            ),
            "graduationYear": random.randint(1980, 2023),
        }
        educations.append(education)
    return educations


def generate_skills(num_skills):
    skills = []
    for i in range(num_skills):
        skill = {
            "id": i + 1,
            "candidateId": random.randint(1, num_candidates),
            "name": random.choice(
                [
                    "Python",
                    "Java",
                    "JavaScript",
                    "C++",
                    "C#",
                    "Ruby",
                    "PHP",
                    "SQL",
                    "HTML",
                    "CSS",
                ]
            ),
            "level": random.choice(["BEGINNER", "INTERMEDIATE", "ADVANCED", "EXPERT"]),
        }
        skills.append(skill)
    return skills


def generate_job_requirements(num_job_requirements):
    job_requirements = []
    for i in range(num_job_requirements):
        job_requirement = {
            "id": i + 1,
            "jobId": random.randint(1, num_jobs),
            "type": random.choice(
                ["EDUCATION", "EXPERIENCE", "SKILL", "CERTIFICATION", "LANGUAGE"]
            ),
            "description": random_string(20),
        }
        job_requirements.append(job_requirement)
    return job_requirements


def generate_recruiters(num_recruiters):
    recruiters = []
    for i in range(num_recruiters):
        recruiter = {
            "id": i + 1,
            "department": random.choice(["HR", "IT", "Finance", "Marketing", "Sales"]),
        }
        recruiters.append(recruiter)
    return recruiters


def generate_social_profiles(num_social_profiles):
    social_profiles = []
    for i in range(num_social_profiles):
        platform = random.choice(["LinkedIn", "Twitter", "Facebook"])
        social_profile = {
            "id": i + 1,
            "platform": platform,
            "profileUrl": f"https://{platform.lower()}.com/{random_string(8)}",
        }
        social_profiles.append(social_profile)
    return social_profiles


def generate_resumes(num_resumes):
    resumes = []
    for i in range(num_resumes):
        resume = {"id": i + 1, "candidateId": random.randint(1, num_candidates)}
        resumes.append(resume)
    return resumes


def generate_job_applications(num_job_applications):
    job_applications = []
    for i in range(num_job_applications):
        job_requirement = {
            "id": i + 1,
            "candidateId": random.randint(1, num_candidates),
            "jobId": random.randint(1, num_jobs),
            "status": random.choice(
                ["SUBMITTED", "UNDER_REVIEW", "INTERVIEWED", "HIRED", "REJECTED"]
            ),
            "applicationDate": random_date(2020, 2023),
        }
        job_applications.append(job_requirement)
    return job_applications


num_candidates = 100
num_users = 50
num_jobs = 20
num_work_experiences = 200
num_educations = 150
num_skills = 300
num_job_requirements = 80
num_recruiters = 10
num_social_profiles = 120
num_resumes = 100
num_job_applications = 300


assert (
    num_candidates
    + num_users
    + num_jobs
    + num_work_experiences
    + num_educations
    + num_skills
    + num_job_requirements
    + num_recruiters
    + num_social_profiles
    + num_resumes
    >= 1000
), "Total number of records should be at least 1000"


candidates = generate_candidates(num_candidates)
users = generate_users(num_users)
job_requisitions = generate_job_requisitions(num_jobs)
work_experiences = generate_work_experiences(num_work_experiences)
educations = generate_educations(num_educations)
skills = generate_skills(num_skills)
job_requirements = generate_job_requirements(num_job_requirements)
recruiters = generate_recruiters(num_recruiters)
social_profiles = generate_social_profiles(num_social_profiles)
resumes = generate_resumes(num_resumes)
job_applications = generate_job_applications(num_job_applications)



def write_data(file, data, name, values: list[dict]):
    writer = csv.writer(csvfile)
    
    header = list(values[0].keys())
    header.append(name)
    
    writer.writerow(header)
    for value in values:
        writer.writerow(value.values())


with open("data/data.csv", "w", newline="") as csvfile:
    writer = csv.writer(csvfile)

    write_data(csvfile, candidates, "candidates", candidates)
    write_data(csvfile, users, "users", users)
    write_data(csvfile, job_requisitions, "job_requisitions", job_requisitions)
    write_data(csvfile, work_experiences, "work_experiences", work_experiences)
    write_data(csvfile, educations, "educations", educations)
    write_data(csvfile, skills, "skills", skills)
    write_data(csvfile, job_requirements, "job_requirements", job_requirements)
    write_data(csvfile, recruiters, "recruiters", recruiters)
    write_data(csvfile, social_profiles, "social_profiles", social_profiles)
    write_data(csvfile, resumes, "resumes", resumes)   
    write_data(csvfile, job_applications, "job_applications", job_applications)

print("Data generation completed. Check the 'data.csv' file.")
