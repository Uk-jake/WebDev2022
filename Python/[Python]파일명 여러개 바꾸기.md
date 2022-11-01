# [Python]파일명 여러개 바꾸기

연구실 프로젝트를 진행하던 도중 **여러개의 파일을 바꿔야할 일**이 생겨 수작업을 할까 고민하던 도중
Python os모듈을 사용하면 금방 끝날 것 같아 os모듈을 사용하여 파일명들을 바꿔보았다.

```python
import os

file_path = 'C:\\Users\\JangUk\\Desktop\\file'

#os.listdir을 사용하면 경로에 존재하는 파일들의 이름들을 리스트 형식으로 얻을 수 있다.
file_list = os.listdir(file_path)

for name in file_list:
    src = os.path.join(file_path, name)     #하나의 파일씩 경로를 지정해주는 것
    dst = str(i) + '.jpg'                   #변경할 이름을 정하는 과정
    dst = os.path.join(file_path, dst)      #join함수를 사용하여 변경할 파일 경로 지정
    os.rename(src, dst)                     #rename함수를 이용하여 파일명 변경
    i += 1
```

내가 해야할 작업들은 강아지들 별로 사진을 모은 후 파일안에 있는 강아지들 사진이름들을 바꾸는 작업이였다.
![img.png](asset/img.png)  
강아지 이름 파일마다 강아지들의 사진들이 들어있는데 이 작업을 하기위해 아래와 같은 코드로 이름을 바꿨다.

```python
import os

def changeFilename(ParentFile, FileName):
    fileDst = ParentFile + "\\" + FileName
    file_names_list = os.listdir(fileDst)

    i = 1

    for name in file_names_list:
        src = os.path.join(fileDst, name)
        dst = FileName + str(i) + '.jpg'
        dst = os.path.join(fileDst, dst)
        os.rename(src, dst)
        i += 1

file_path = 'C:\\Users\\JangUk\\Desktop\\강아지비문자료'

dirList = os.listdir(file_path)
print(dirList)

for name in dirList:
    changeFilename(file_path, name)
```