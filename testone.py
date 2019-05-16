import math
"""求10个数的平均值
N = 10
total = 0
count = 0
print("Please input 10 numbers:")
while count < N:
   number = float(input())
    total += number
    count = count + 1
print("N={},sum={}".format(N,total))
print("result is : {} ".format(total/N))"""

"""华氏度转化为摄氏度C = (F - 32) / 1.8
F = 0
while F < 250:
    C = (F-32)/1.8
    print("F={}   C={:7.2f}".format(F,C))
    1)+1/(x+2)+ ... +1/n，我们设 x = 1，n = 10
""""result = 0F = F + 25"""
#计算数列 1/x+1/(x+
"""for i in range(1,11):
    result += 1.0/i
    print("{:2d} {:6.4f}".format(i,result))"""
#圆的面积
"""s = input("Enter String:")
print("The string have %d words" % (len(s.split(" "))))"""
"""a = 2
b = 1
a , b=b , a+b
print(b)"""
#打印星号
"""n = int(input("Enter you rows:"))
if n<0:
    print("error")
while n != 0:
    print("*"*n)
    n -= 1"""
#棍子游戏
#玩家选择1~4根棍子，电脑选择1~4根棍子,两个之和为5
#谁选择最后一根，谁就赢

"""gun = 3
input("Customer choice 1 to 4 guns, and computer choice to 1~4")
input("if choice last gun, it is victory")

while True:
    last_gun = int(input("Please choice"))
    if gun <= 1:
        print("you are winner")
        break
    if last_gun>=5 or last_gun<=0:
        print("input is error")
        continue
    print("Computer choice is "+str((2-last_gun)))
    gun -= 1"""
"""a = [1,2,3]
print(a.pop())"""
"""a = {"gray" , "green" , "silver"}
a.add("ad")
a.add("aasd")
a.add("aaasdfdsf")
print(a)"""
fobj = open("G:/workspace/123.txt","a")
fobj.write("World ")
fobj.write("is ")
fobj.write("simple ")
fobj.write("code ")
fobj.close()





