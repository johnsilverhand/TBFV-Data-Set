import math

def send_text(self, content):
    if not content:
        return  # 如果内容为空，不发送任何请求

    content_size = len(content)
    trunk = 4096  # 设置文本片段长度为 4096 字符
    last = 0

    for _ in range(math.ceil(content_size / trunk)):
        end = min(last + trunk, content_size)
        text = content[last:end]

        # 优化截断到最近的换行符
        if end != content_size:
            new_end = text.rfind('\n')
            if new_end != -1:
                text = text[:new_end]
                end = last + new_end

        # 模拟发送请求
        print(f"发送请求：{text}")
        last = end
