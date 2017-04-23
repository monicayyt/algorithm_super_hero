def check_dup(arr):

    #create counting dictionary
    count = {}
    
    results = []
    
    #loop through the string to fill in the dictionary
    for num in arr:
        # found dups, print it out
        if num in count:
            count[num] +=1
            results.append(num)
        # no dups found, push to dictionary
        else:
            count[num] =1
    print(results)
            
    return results
    
    
#test cell
from nose.tools import assert_equal

class Check_dupTest(object):
    
    def test(self, sol):
        assert_equal(sol([1, 5, 2, 1, 4, 3, -1, 7, 2, 8, 9, 5]),[1,2,5])
        print('ALL TEST CASES PASSED')
        
#run test
t = Check_dupTest()
t.test(check_dup)
