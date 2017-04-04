#!/bin/bash
set -eu

/server &
ID=$! # ID of webserver process, so we can kill it

tests_passed=true
expected="DevOpsCampApi Running"
output=output=$(curl -s localhost:8080/service/user/health)
if [[ "$expected" != "$output" ]]; then
  echo "Test Failure"
  echo "$expected != $output"
  tests_passed=false
fi

kill $ID

if [[ "$tests_passed" == "true" ]]; then
  echo "Passed Tests"
else
  echo "Failed Tests"
  exit 1
fi
