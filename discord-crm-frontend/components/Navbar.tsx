import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import Image from "next/image";
import Link from "next/link";
import logo from "../img/odyn_logo.png";

const Navbar = () => {
  return (
    <div className="bg-primary dark:bg-slate-700 text-white py-2 px-5 flex justify-between">
      <Link href="/">
        <Image src={logo} alt="crmLOGO" width={40} />
      </Link>
<p className="text-center font-bold text-2xl"> Development build</p>
      <DropdownMenu>
        <DropdownMenuTrigger className="focus:outline-none">
          <Avatar>
            <AvatarImage src="https://github.com/shadcn.png" alt="@shadcn" />
            <AvatarFallback className="text-black"> O</AvatarFallback>
          </Avatar>
        </DropdownMenuTrigger>
        <DropdownMenuContent>
          <DropdownMenuLabel>My Account</DropdownMenuLabel>
          <DropdownMenuSeparator />
          <DropdownMenuItem><Link href={'/profile'}>Profile</Link></DropdownMenuItem>
          <DropdownMenuItem><Link href={'/billing'}>Billing</Link></DropdownMenuItem>
          <DropdownMenuItem><Link href={'/stats'}>Discord Statistics</Link></DropdownMenuItem>
          <DropdownMenuItem><Link href={'/musicBot'}>MusicBot</Link></DropdownMenuItem>
          <DropdownMenuItem><Link href={'/auth'}>Logout</Link></DropdownMenuItem>
        </DropdownMenuContent>
      </DropdownMenu>
    </div>
  );
};

export default Navbar;
