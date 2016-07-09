def fourLettersInCommon(source, dictionary_array):
    #initialise variables and arrays

    result = []
    four = []
    fourstr = ''


    #split the word into four letter chunks
    for i in range(0, len(source)-3):
        for j in range(i,i+4):
            fourstr  += source[j]
        four += [fourstr]
        fourstr = ''

    #compare string with dictionary array strings
    for subWord in four:
        for word in dictionary_array:
            if subWord.lower() in word.lower():
                if word not in result:
                    result += [word]
                else:
                    continue
            else:
                continue
    result.sort()
    return result



#open dictionary file
file_open = open("dictionary.txt", 'r')
dictionary_read = file_open.read()
dictionary = dictionary_read.split('\n')

#Call function

x = fourLettersInCommon("FANTASTIC",dictionary)
print(x)
print(len(x))
