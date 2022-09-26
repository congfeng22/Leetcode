def rotate(matrix):
    """
    Do not return anything, modify matrix in-place instead.
    """
    for i in range(len(matrix)//2):
        for j in range(len(matrix)-2*i-1):
            matrix[i][i+j], matrix[i+j][len(matrix)-1-i], matrix[len(matrix)-1-i][len(matrix)-1-i-j], matrix[len(matrix)-1-i-j][i] = matrix[len(matrix)-1-i-j][i], matrix[i][i+j], matrix[i+j][len(matrix)-1-i], matrix[len(matrix)-1-i][len(matrix)-1-i-j]
    return