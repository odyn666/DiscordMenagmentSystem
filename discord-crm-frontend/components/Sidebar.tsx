import {
  Command,
  CommandEmpty,
  CommandGroup,
  CommandInput,
  CommandItem,
  CommandList,
  CommandSeparator
} from "@/components/ui/command";

import { CreditCard, Folders, LayoutDashboard, Newspaper, Settings, User } from 'lucide-react';
import Link from "next/link";


const Sidebar=() =>{
return(
    <Command className="bg-secondary rounded-none">
  <CommandInput placeholder="Type a command or search..." />
  <CommandList>
    <CommandEmpty>No results found.</CommandEmpty>
    <CommandGroup heading="Suggestions">
      <CommandItem>
        <LayoutDashboard className="mr-2 h-4 w-4" />
        <Link href='/'>Dashboard</Link>
      </CommandItem>
      <CommandItem><Newspaper className="mr-2 h-4 w-4" />
      <Link href='/posts'>Posts</Link>
      </CommandItem>
      <CommandItem>
      <Folders className="mr-2 h-4 w-4" />
      <Link href='/cat'>Categories</Link>
      </CommandItem>
      <CommandItem>
      <Folders className="mr-2 h-4 w-4" />
      <Link href='/cat'>Discord CRM</Link>
      </CommandItem>
    </CommandGroup>
    <CommandSeparator />
    <CommandGroup heading="Settings">
      <CommandItem>
      <User className="mr-2 h-4 w-4" />
      <Link href='/profile'>profile</Link>
      </CommandItem>
      <CommandItem>
      <CreditCard className="mr-2 h-4 w-4" />
      <Link href='/billing'>Billing</Link>
      </CommandItem>
      <CommandItem>
      <Settings className="mr-2 h-4 w-4" />
      <Link href='/settings'>Settings</Link>
      </CommandItem>
    </CommandGroup>
  </CommandList>
</Command>

);
}

export default Sidebar;