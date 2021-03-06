# 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。
# 
# 为了简单起见，你可以假设：
# 
# words.txt只包括小写字母和 ' ' 。
# 每个单词只由小写字母组成。
# 单词间由一个或多个空格字符分隔。
# 示例:
# 
# 假设 words.txt 内容如下：
# 
# the day is sunny the the
# the sunny is is
# 你的脚本应当输出（以词频降序排列）：
# 
# the 4
# is 3
# sunny 2
# day 1
# 说明:
# 
# 不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。
# 你可以使用一行 Unix pipes 实现吗？

# 方法1
awk '{
    for(i=1; i<=NF; i++) {
        res[$i] += 1; #累计数量
    }
}
END {
    for(j in res) {
        print j" "res[j];
    }
}' words.txt | sort -nr -k2 # 按词频降序排列

# 方法2
cat words.txt|tr -s ' ' '\n'|sort|uniq -c|sort -r|awk '{print $2,$1}'
