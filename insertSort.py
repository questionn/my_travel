#直接插入排序
array = [34,98,24,78,34,12]
for index in range(1,len(array)):
	tmp = array[index]
	result = list(range(-1,index))
	result.reverse()
	# 1 0 -1
	for next_index in result:
		if(tmp < array[next_index]):
			array[next_index+1] = array[next_index]
		else:
			break;
	array[next_index+1] = tmp
print(array)


			
