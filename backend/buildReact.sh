#!/bin/bash

/usr/bin/pkill -f with-dependencies
pwd
echo $1
cd $1
npm install npm start
npm run build

