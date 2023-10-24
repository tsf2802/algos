from random import randint
testcaselen = [20,40,60,80,100,120,140,160,180]

for i,val in enumerate(testcaselen):
    
    name = "testcase"+str(i)+".txt"
    file_obj = open(name, "w")
    #file_obj.write(str(testcaselen[i])+"\n")
    strr=""
    for j in range(0,val):
        value = randint(0, 1000)
        strr= strr+str(value)
        if j != val-1:
            strr=strr+","
    strr = strr+""
    file_obj.write(strr)