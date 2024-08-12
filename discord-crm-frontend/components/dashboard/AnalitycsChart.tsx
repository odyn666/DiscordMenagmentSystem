"use client";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import data from "@/data/analitycs";
import {
  CartesianGrid,
  Line,
  LineChart,
  ResponsiveContainer,
  XAxis,
  YAxis,
} from "recharts";
const AnalitycsChart = () => {
  return (
    <>
      <Card>
        <CardHeader>
          <CardTitle>Analitycs for this month</CardTitle>
          <CardDescription>Activity this month</CardDescription>
        </CardHeader>
          <CardContent>
            <div style={{ width: '100%', height: 300 }}>
              <ResponsiveContainer>
                <LineChart width={1100} height={300} data={data}>
                  <Line type='monotone' dataKey='uv' stroke='#8884d8' />
                  <CartesianGrid stroke='#ccc' />
                  <XAxis dataKey='name' />
                  <YAxis />
                </LineChart>
              </ResponsiveContainer>
            </div>
          </CardContent>
      </Card>
    </>
  );
};

export default AnalitycsChart;
