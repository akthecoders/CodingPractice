<?php

// Program to find weather there is path to from start to end in the maze for the bot.
// Maze - It is a 2 dimensional matrix with 0 (block) & 1 (valid box). A bot can travel via 1 boxes only.


$input = [];
$input[0][0] = 1;
$input[0][1] = 1;
$input[0][2] = 0;
$input[1][0] = 1;
$input[1][1] = 1;
$input[1][2] = 1;
$input[2][0] = 0;
$input[2][1] = 0;
$input[2][2] = 1;

$size = count($input);

$path = [];
$path[0][0] = 0;
$path[0][1] = 0;
$path[0][2] = 0;
$path[1][0] = 0;
$path[1][1] = 0;
$path[1][2] = 0;
$path[2][0] = 0;
$path[2][1] = 0;
$path[2][2] = 0;

// Function to find the path.
function doesPathExists($params, &$path, $x, $y, $size)
{
  if (($x == $size - 1 && $y == $size - 1)) {
    if ($params[$x][$y] == 1) {
      $path[$x][$y] = 1;
      return true;
    } else
      return false;
  }

  if ($x > $size || $y > $size) {
    return false;
  }

  if (!isset($params[$x][$y])) {
    return false;
  } elseif ($params[$x][$y] == 0 || $path[$x][$y] == 1) {
    return false;
  }

  $path[$x][$y] = 1;

  // top
  $ans = doesPathExists($params, $path, $x - 1, $y, $size);
  if ($ans == true) return true;

  // right
  $ans = doesPathExists($params, $path, $x, $y + 1, $size);
  if ($ans == true) return true;

  // bottom
  $ans = doesPathExists($params, $path, $x + 1, $y, $size);
  if ($ans == true) return true;

  // left
  $ans = doesPathExists($params, $path, $x, $y + 1, $size);
  if ($ans == true) return true;

  return false;
}

$pathExists = doesPathExists($input, $path, 0, 0, $size);
if ($pathExists) {
  echo "Path Exists \nPath : ";
  for ($i = 0; $i < $size; $i++) {
    for ($j = 0; $j < $size; $j++) {
      if ($path[$i][$j] == 1) {
        if ($i == $size - 1 && $j == $size - 1) {
          echo "(" . $i . "," . $j . ")";
        } else
          echo "(" . $i . "," . $j . ") => ";
      }
    }
  }
} else {
  echo "No path to get out";
}
echo "\n";
