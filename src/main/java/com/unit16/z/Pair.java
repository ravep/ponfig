package com.unit16.z;

import com.google.common.base.MoreObjects;

public interface Pair<A,B> {

	public A fst();
	public B snd();
	
    public static class I<A,B> implements Pair<A,B> {

        public A fst;
        public B snd;
        
        public I(A a, B b) {
            fst = a;
            snd = b;
        }
        
        public void copyFrom(Pair<A, B> val) {
            fst = val.fst();
            snd = val.snd();
        }

        @Override
        public A fst() {
            return fst;
        }

        @Override
        public B snd() {
            return snd;
        }
        
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(Pair.class)
                    .add("fst", fst)
                    .add("snd", snd)
                    .toString();
        }

        public static <A, B> Pair.I<A, B> pair(A a, B b) {
            return new Pair.I<A, B>(a, b);
        }
               
    }
    
    public static class Uniform<A> extends I<A,A> {

		public Uniform(A a, A b) {
			super(a, b);
		}
		
        public static <A> Pair.Uniform<A> uniform(A a, A b) {
            return new Pair.Uniform<A>(a, b);
        }
    	
    }
	
}
