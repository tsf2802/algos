from random import randint
testcaselen = [500,1000,15000,20000,25000,30000,35000,40000,45000,50000]
finall = []
for i,val in enumerate(testcaselen):
    temparr =[]
    for j in range(0,val):
        value = randint(0, 1000)
        temparr.append(value)
    finall.append(temparr)

import subprocess
import time
 # Replace with your actual array data

for array_data in finall:
    start_time = time.time()
    command = ['java', 'LongestIncreasingSubseqDP.java', len(array_data),array_data]
    process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    stdout, stderr = process.communicate()

    if process.returncode == 0:
        end_time = time.time()
        elapsed_time = end_time - start_time
        print(f"Array data: {array_data}")
        print(f"Java program completed in {elapsed_time:.2f} seconds.")
        print(f"Final value: {stdout}")
    else:
        print(f"Error running the Java program: {stderr}")