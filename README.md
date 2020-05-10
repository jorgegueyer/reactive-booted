# Simple Reactive API

Simple Reactive API with a single endpoint. The actual state of the project serves as template to add new features.

Improvements will arrive soon.

## How to deploy on Docker

Go to the folder project:

```console
cd path/to/the/folder/reactive-booted
```

Build the Dockerfile:

```console
docker build -t reactive-booted .

...output omitted...
Successfully tagged reactive-booted:latest
```

Check the image has been created properly:

```console
docker images

REPOSITORY                            TAG                 IMAGE ID            CREATED             SIZE
reactive-booted                       latest              041fcc62de52        18 seconds ago      476MB
registry.access.redhat.com/ubi8/ubi   8.2                 8e0b0194b7e1        2 weeks ago         204MB
```

Run the container:

```console
docker run -d -p 8080:8080 --name reactive-booted reactive-booted

71eb94fb29f8b7d6d5cf8bcdfc6b9839930081aaf1a743be120e37f5f5a5ff3d
```

Invoke the endpoint!

```console
curl http://localhost:8080/main

The main service has been called!
```

Delete the resource created:

```console
docker stop reactive-booted
docker rm reactive-booted
docker rmi 041fcc62de52 
```
> NOTE
>> The hash of the CONTAINER_ID to remove the image of the container can be obtained with ***docker images*** command. 

