#!/bin/sh
 
while inotifywait -e modify $1; do
    gradle --daemon test
done
