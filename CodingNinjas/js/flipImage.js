let input = [
          [0, 1, 1, 1],    
          [1, 0, 0, 1],
          [1, 0, 1, 1],
        ];

let i = 0;
let newMatrix = [rows][columns];
let count = 0;
input.forEach((element, key) => {
  count = 0;
  for(i = rows - 1; i >= 0; i--) {
    newMatrix[key][count++] = element[i];
  }
});
console.log(newMatrix);