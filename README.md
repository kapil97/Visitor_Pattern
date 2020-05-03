# CSX42: Assignment 4
## Name: Kamleshwar Ragava

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in visitPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile visitPlay/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile visitPlay/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Use the below command to run the program.

```commandline
ant -buildfile visitPlay/src/build.xml run \
-Dinput="input.txt" \
-DacceptableWordsFile="acceptable_words.txt" \
-Dk=2 \
-DtopKOutputFile="topk_output.txt" \
-DspellCheckOutputFile="spellcheck_output.txt"
```

-----------------------------------------------------------------------
## Description:

To implement Visitor Pattern, and visit the Sentences encapsulated into Elements.<br>
There are Two Visitors: ```TopKMostFreqAnalyzer``` and ```SpellCheckAnalyzer```.<br>
```TopKMostFreqAnalyzer``` is implemented using ```k Value``` and priority Queue.<br>
```SpellCheckAnalyzer``` is implemented using acceptable words file.<br>
References: priority queue referred from PK's piazza post.<br>
<br>
Number of Slack Days Used:1

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 05/03/2020


