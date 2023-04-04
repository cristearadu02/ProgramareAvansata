package Homework;

public class Line {

    Dot start, end;

    public Line(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    public Dot getStart() {
        return start;
    }

    public Dot getEnd() {
        return end;
    }

    public boolean isConnected(Line x)
    {
        if(this.getStart() == x.getStart() || this.getStart() == x.getEnd())
            return true;
        if(this.getEnd() == x.getStart() || this.getEnd() == x.getEnd())
            return true;
        return false;
    }
    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
