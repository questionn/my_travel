#创建一个名为Restaurant 的类，其方法__init__() 设置两个属性：
#restaurant_name 和cuisine_type 。创建一个名
#为describe_restaurant() 的方法和一个名为open_restaurant() 的方法，
#中前者打印前述两项信息，而后者打印一条消息，指出餐馆正在营业。
class Restaurant():
	"""创建一个基本的餐馆类"""
	
	"""构造方法"""
	def __init__(self,restaurant_name,cuisine_type):
		self.cuisine_type = cuisine_type 
		self.restaurant_name = restaurant_name
	
	"""普通方法"""
	
	def describe_restaurant(self):
		print("restaurant_name is " + self.restaurant_name)
		print('cuisine_type is ' + self.cuisine_type)
	
	def open_restaurant(self):
		print(self.restaurant_name + " operating ")

#继承

class Food_Restaurant(Restaurant):
	
	def __init__(self,restaurant_name,cuisine_type,food_type):
		super().__init__(restaurant_name,cuisine_type)
		self.food_type = food_type
	
	def open_restaurant(self):
		print(food_type + " - " +  self.restaurant_name + ' operating')
	
	def describe_restaurant(self):
		print("restaurant_name is " + self.restaurant_name)
		print('cuisine_type is ' + self.cuisine_type)
		print("food_type is " + self.food_type)
#实例化一个对象	
my_restaurant = Restaurant("KFC","quick_food")
#改变对象中的属性值
my_restaurant.restaurant_name = "RJM"
#继承一个类
my_food_restaurant = Food_Restaurant("KFC","quick_food","apple")
my_food_restaurant.describe_restaurant()
my_restaurant.describe_restaurant()
my_restaurant.open_restaurant()
	
