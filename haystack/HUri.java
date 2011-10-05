//
// Copyright (c) 2011, SkyFoundry, LLC
// Licensed under the Academic Free License version 3.0
//
// History:
//   09 Jun 2011  Brian Frank  Creation
//
package haystack;

/**
 * HStr models a URI as a string.
 */
public class HUri extends HVal
{
  /** Construct from string value */
  public static HUri make(String val)
  {
    if (val.length() == 0) return EMPTY;
    return new HUri(val);
  }

  /** Singleton value for empty URI */
  private static final HUri EMPTY = new HUri("");

  /** Private constructor */
  private HUri(String val) { this.val = val; }

  /** String value of URI */
  public final String val;

  /** Hash code is based on string value */
  public int hashCode() { return val.hashCode(); }

  /** Equals is based on string value */
  public boolean equals(Object that)
  {
    if (!(that instanceof HUri)) return false;
    return this.val.equals(((HUri)that).val);
  }

  /** Encode value to string format */
  public void write(StringBuilder s) { write(s, val); }

  /** Encode value to string format */
  static void write(StringBuilder s, String val)
  {
    s.append('`');
    for (int i=0; i<val.length(); ++i)
    {
      int c = val.charAt(i);
      if (c < ' ' || c > 127 || c == '`') throw new IllegalArgumentException("Invalid URI char '" + val + "', char='" + (char)c + "'");
      s.append((char)c);
    }
    s.append('`');
  }

}