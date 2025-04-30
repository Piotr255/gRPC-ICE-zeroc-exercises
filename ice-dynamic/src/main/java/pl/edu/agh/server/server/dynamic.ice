
#ifndef CALC_ICE
#define CALC_ICE

module Demo
{
  struct A
  {
    float a;
    float b;
    float c;
    string d;
  };

  sequence<A> numberList;

  exception NoInput {};

  interface Calc
  {
    idempotent long add(int a, int b) throws NoInput;
    idempotent long subtract(int a, int b);
    void op(A a1, short b1); //załóżmy, że to też jest operacja arytmetyczna ;)
    idempotent string avg(numberList List);
  };

};

#endif
