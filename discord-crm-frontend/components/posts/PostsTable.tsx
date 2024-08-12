import { Table, TableBody, TableCaption, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table';
import posts from '@/data/posts';
import { Post } from '@/types/posts';
import Link from 'next/link';

interface PostTableProps{
    limit?:number,
    title?:string
}


const PostsTable = ({limit,title}:PostTableProps) => {
const sortedPostsByDate:Post[]=[...posts].sort((a,b)=>new Date(b.date).getTime()-new Date(a.date).getTime());

const filtredPosts=limit?sortedPostsByDate.slice(0,limit):sortedPostsByDate;

    return  <div className='mt-10'>
        <h3 className="text-2xl mb-4 font-semibold">
            {title?title:'Tickets'}
        </h3>
        <Table>
            <TableCaption>
                A list of recent tickets
            </TableCaption>
            <TableHeader>
                <TableRow>
                    <TableHead>name</TableHead>
                    <TableHead className='hidden md:table-cell'>Author</TableHead>
                    <TableHead className='hidden md:table-cell text-right'>Date</TableHead>
                    <TableHead>View</TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                {filtredPosts.map((post)=>(
                    <TableRow key={post.id}>
                        <TableCell >{post.title}</TableCell>
                        <TableCell className='hidden md:table-cell'>{post.author}</TableCell>
                        <TableCell className='text-right hidden md:table-cell'>{post.date}</TableCell>
                        <TableCell >
                            <Link href={`/posts/edit/${post.id}`}>
                            <button className='bg-blue-500 hover:bg-blue-700 text-white font-bold py-4 px-4 rounded text-sx'>
Edit
                                </button>
                                </Link>
                            </TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    </div> ;
};
 
export default PostsTable;