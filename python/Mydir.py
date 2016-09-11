import os
import shutil

path = 'E:\myfiles\short_programs\python';
list_ = os.listdir(path);


for file_ in list_:
    name, ext = os.path.splitext(file_);
    print(name);