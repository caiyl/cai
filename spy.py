import redis

# 创建 Redis 连接对象
r = redis.Redis(host='localhost', port=6379, db=0)

# 读取文件，并将每行内容添加到 Redis Set 中
with open('/Users/chase/物联网卡/cardids.csv', 'r') as f:
    for line in f:
        # 去掉行末的换行符
        line = line.rstrip()
        # 将行内容添加到 Redis Set 中
        r.sadd('myset', line)

# 输出 Redis Set 中的所有元素
# print(r.smembers('myset'))
