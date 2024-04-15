#!/bin/sh
let v=$(svn info --show-item revision);
v=$((v-2));
svn export -r $v . revision2 --force
