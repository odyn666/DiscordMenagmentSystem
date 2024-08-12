import Navbar from "@/components/Navbar";
import Sidebar from "@/components/Sidebar";
import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Discord CRM",
  description: "Change this later",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Navbar></Navbar>
        <div className="flex">
          <div className="hidden md:block h-[100vh] w-[300px]">
<Sidebar></Sidebar>
          </div>
          <div className="p-5 w-full md:max-w-[1140px]">
        {children}

          </div>
        </div>
      </body>
    </html>
  );
}
