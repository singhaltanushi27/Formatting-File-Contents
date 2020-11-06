# Formatting-File-Contents
Long format(String filePath, String[] wordsToFormat, string format){}

This method will take the following parameters:
filePath : a file path that needs to be formatted!
wordsToFormat: Array of a string containing words that need to be formatted.
format: this parameter should be case insensitive and should accept following values:
TitleCase
LowerCase
UpperCase
Return value: Total number of words formatted! For example, if the 100 words of the file are formatted it should return 100!

format(“c:/myFolder/myFile.text”, [“One”, “Two”], “LowerCase”);

The above statement should update all the One and Two in lower case i.e. one two. 

