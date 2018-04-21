#!/bin/bash

rm jeuoie/*.class

javac jeuoie/*.java

java -cp . jeuoie.JeuOie
