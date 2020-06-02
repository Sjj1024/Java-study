from redis import StrictRedis


# 创建一个redis对象
redis = StrictRedis(host="127.0.0.1", port=6379)

# 使用对象的set和get方法获取和存储数据
# res = redis.set("home", "洛阳")
# print(res)

# 从数据库中取出数据
# res = redis.get("home").decode("utf-8")
# print(res)

# 列表类型的值存储
# res = redis.lpush("mylist", "g")
# print(res)

# 删除列表中的数据
# res = redis.lpop("mylist")
# print(res)

# 查询列表中所有的内容
# res = redis.lrange("mylist", 0, -1)
# for i in res:
#     print(i.decode("utf-8"))

"""
redis持久化操作：redis是内存型数据库，当关机或重启后，数据就没有了，所以为了让数据能够保存，使用了持久化存储机制，
当900秒后，如果有1个key发生变化，就保存
save 900 1
当300秒后，如果有10个key发生变化，就保存
save 300 10
当60秒后，如果有10000个key发生变化，就保存
save 60 10000
"""
