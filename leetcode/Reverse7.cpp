#include <climits>
#include <queue>

class Reverse7
{
public:
    int reverse(int x)
    {
        int soln = 0;
        while (x != 0)
        {
            if ((soln > INT_MAX / 10) || (soln < INT_MIN / 10))
                return 0;
            soln = (10 * soln) + (x % 10);
            x /= 10;
        }
        return soln;
    }
};