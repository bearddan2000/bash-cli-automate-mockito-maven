#! /bin/bash

function replace_readme_str() {
  #statements
  local file=$1/README.md
  local old=$2
  local new=$3

  perl -pi.bak -0 -e "s/${old}/${new}/" $file
  rm -f $1/README.md.bak
}

replace_readme_str $1 "cucumber-" "cucumber-mockito-"

replace_readme_str $1 "cucumber," "cucumber, mockito, "

replace_readme_str $1 "- maven" "- maven\n\t- mockito"
