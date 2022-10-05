def maximumsSplicedArray(nums1, nums2):
    n = len(nums1)
    # inc1[k] = max increase to sum(nums1) across all [i,k) swaps
    inc1 = [0 for _ in range(n+1)]
    # inc2[k] = max increase to sum(nums2) across all [i,k) swaps
    inc2 = [0 for _ in range(n+1)]
    
    # base case: inc1[0] = inc2[0] = 0 because no swaps means no increases
    for k in range(1,n+1):
        # biggest increase to sum(nums1) across all [i,k) swaps must be biggest increase across all [i,k-1) swaps + increase in swapping k-1
        inc1[k] = max(0,inc1[k-1]+nums2[k-1]-nums1[k-1])
        inc2[k] = max(0,inc2[k-1]+nums1[k-1]-nums2[k-1])
    # print(inc1)
    # print(inc2)
    return max(sum(nums1) + max(inc1), sum(nums2) + max(inc2))