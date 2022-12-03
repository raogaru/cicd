FROM alpine:3.16
LABEL MAINTAINER="raogaruinc@gmail.com"

RUN apk --no-cache add \ 
      bash \
      curl \
      less \
      groff \
      jq \
      git \
      python3 \
      py3-pip \
      py-pip && \
      pip install --upgrade pip awscli s3cmd && \
      mkdir /root/.aws

COPY get-metadata /usr/local/bin/get-metadata
