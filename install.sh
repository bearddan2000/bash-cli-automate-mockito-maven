#! /bin/bash

function copy-src() {
  #statements
  local test_dir="$(pwd)/$1/bin/src/test"

  rm -Rf $test_dir

  cp -R ./.src/$2 $test_dir
}

for d in `ls -la | grep ^d | awk '{print $NF}' | egrep -v '^\.'`; do

  ./.src/mockito.py $(pwd)/$d/bin/pom.xml

  ./readme.sh $d

  e=""

  case $d in
    *junit* )
      case $d in
        *car-data* ) e="junit/car-data-test" ;;
        *hello-world* ) e="junit/hello-world-test" ;;
      esac ;;
      *testng* )
        case $d in
          *car-data* ) e="testng/car-data-test" ;;
          *hello-world* ) e="testng/hello-world-test" ;;
        esac ;;
  esac

  copy-src $d $e

  ./folder.sh $d
done
