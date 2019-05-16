def download(url):
    """下载URl的资源到指定的目录
        URL要下载内容的页面"""
    #判断URL是否存在
    try:
        rep = requests.get(url)
    except requests.exceptions.MissingSchema:
        print("无效的URl")

    if rep.status_code == 404:
        raise requests.exceptions.ConnectionError("服务器有误")
    with open("G:/workspace/13.txt","w") as fobj:
        fobj.write(rep.content.decode("utf-8"))
    print("下载完毕")

if __name__ == "__main__":
    url = input("Please input URl: ")
    download(url)