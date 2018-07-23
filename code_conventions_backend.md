## B. For JAVA 
#### 1. Naming
| Identifier Type | Rules for Naming | Examples                  |
|:----------------| :-------------- | :------------------------- |
| Classes |  Class names should be nouns, in mixed case with the first letter of each internal word capitalized. Try to keep your class names simple and descriptive. Use whole words—avoid acronyms and abbreviations (unless the abbreviation is much more widely used than the long form, such as URL or HTML). | class Raster; class ImageSprite; |
| Interfaces | Interface names should be capitalized like class names. | interface RasterDelegate; interface Storing; |
| Methods | Methods should be verbs, in mixed case with the first letter lowercase, with the first letter of each internal word capitalized | run(); runFast(); getBackground(); |
| Variables | Except for variables, all instance, class, and class constants are in mixed case with a lowercase first letter. Internal words start with capital letters. Variable names should be short yet meaningful. The choice of a variable name should be mnemonic— that is, designed to indicate to the casual observer the intent of its use. One-character variable names should be avoided except for temporary “throwaway” variables. Common names for temporary variables are i, j, k, m, and n for integers; c, d, and e for characters. | int i; char *cp; float myWidth; |
| Constants | The names of variables declared class constants and of ANSI constants should be all uppercase with words separated by underscores (“_”). (ANSI constants should be avoided, for ease of debugging.) | int MIN_WIDTH = 4; int MAX_WIDTH = 999; int GET_THE_CPU = 1; |

