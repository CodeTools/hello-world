# python String manipulation
text = input();
query = input();
list = [];
for i in range(0, len(text)):
    for j in range(0, len(query)):
        if i + j >= len(text):
            break;
        if text[i + j:i + j + 1] != query[j:j + 1]:
            break;
        if j == len(query) - 1:
            list.append(i);
print(len(list));