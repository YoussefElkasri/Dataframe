FROM ubuntu:latest

RUN apt-get update

ADD . /app/
WORKDIR /app
