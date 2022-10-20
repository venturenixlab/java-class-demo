package com.vtxlab.utility;

public class IntSortHolder {
  int[] arr;

  public IntSortHolder(int[] arr) {
    this.arr = arr;
  }

  public int[] getArray() {
    return this.arr;
  }

  public void setArray(int[] arr) {
    this.arr = arr;
  }

  public IntSortHolder sortBy(IntSortHelper sortHelper) {
    SortUtil.sort(this.arr, sortHelper);
    return this;
  }

  @Override
  public String toString() {
    String s = "[";
    for (int r : this.arr) {
      s += r + ", ";
    }
    s += "]";
    return s;
  }

}
