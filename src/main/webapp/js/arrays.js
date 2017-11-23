var plusOne = function (digits) {
    for (let index = digits.length-1; index >=0; index++) {
        if (digits[index] === 9)
            digits[index] = 0;
        else {
            digits[index + 1] += 1;
            break;
        }
    }
};