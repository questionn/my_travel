results = [2,34,45,7,5,7]
for index in range(0,len(results)):
	for next_index in range(index+1,len(results)):
		if results[next_index]<results[index] :
			tmp = results[next_index]
			results[next_index] = results[index]
			results[index] = tmp
print(results)

