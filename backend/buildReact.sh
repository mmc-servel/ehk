#!/bin/bash

/usr/bin/pkill -f with-dependencies
cd $1
npm run build

