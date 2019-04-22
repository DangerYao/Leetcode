# Read from the file file.txt and output the tenth line to stdout.

# 方法1
sed -n "10,10p" file.txt

# 方法2
awk 'NR == 10' file.txt #速度更快一些
