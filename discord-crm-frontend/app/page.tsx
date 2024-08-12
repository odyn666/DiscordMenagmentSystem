import AnalitycsChart from '@/components/dashboard/AnalitycsChart';
import DashboardCard from "@/components/dashboard/DashboardCard";
import PostsTable from "@/components/posts/PostsTable";
import { Folder, MessageCircle, Newspaper, User } from "lucide-react";

export default function Home() {
  return (
   <>
  <div className="flex flex-col md:flex-row justify-between gap-5 mb-5">
    <DashboardCard title="tickets" count={100} icon={<Newspaper className="text-slate-500" size={72} />}/>
    <DashboardCard title="categories" count={12} icon={<Folder className="text-slate-500" size={72} />}/>
    <DashboardCard title="Users" count={75} icon={<User className="text-slate-500" size={72} />}/>
    <DashboardCard title="messages per day AVG." count={1200} icon={<MessageCircle className="text-slate-500" size={72} />}/>

  </div>
<AnalitycsChart></AnalitycsChart>
  <PostsTable limit={5}></PostsTable>
   </>
  );
}
