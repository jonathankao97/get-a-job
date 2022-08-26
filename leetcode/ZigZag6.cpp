#include <string>
#include <vector>

using namespace std;

class ZigZag6
{
public:
    string convert(string s, int numRows)
    {
        if (numRows == 1)
            return s;

        vector<char> rows[numRows];
        int currRow = 0;
        int step = 1;
        for (char c : s)
        {
            rows[currRow].push_back(c);
            if (step == 1 && currRow == numRows - 1)
                step = -1;
            if (step == -1 && currRow == 0)
                step = 1;
            currRow += step;
        }
        string soln = "";
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < rows[i].size(); j++)
                soln += rows[i].at(j);
        }
        return soln;
    }
};