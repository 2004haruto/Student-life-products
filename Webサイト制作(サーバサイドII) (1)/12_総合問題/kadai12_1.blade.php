<x-app-layout>
    <div name="contents" class="mx-5 p-5">
            <div style="position:sticky;">
                <form action="{{ route('kadai12_1.store') }}" method="POST" class="w-full mt-5">
                    @csrf
                    <textarea class="w-full rounded-lg border-slate-400" name="comment"></textarea>
                    <div class="flex flex-row-reverse">
                        <button type="submit" class="rounded-lg border bg-teal-300 py-2 px-5 mt-3">送信</button>
                    </div>
                </form>
            </div>

        <div>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名１</li>
                            <li class="text-lg">ここにささやき内容１</li>
                        </ul>
                    </div>
                </li>
            </ul>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名２</li>
                            <li class="text-lg">ここにささやき内容２</li>
                        </ul>
                    </div>
                </li>
            </ul>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名３</li>
                            <li class="text-lg">ここにささやき内容３</li>
                        </ul>
                    </div>
                </li>
            </ul>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名４</li>
                            <li class="text-lg">ここにささやき内容４</li>
                        </ul>
                    </div>
                </li>
            </ul>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名５</li>
                            <li class="text-lg">ここにささやき内容５</li>
                        </ul>
                    </div>
                </li>
            </ul>
            <ul class="flex w-full">
                <li class="w-1/12 h-20">
                    <div class="flex items-center">
                        <svg width="80" height="80">
                            <rect class="rect-bg-pink"></rect>
                            <text class="text-sm" x="10" y="45">ここに画像</text>
                        </svg>
                    </div>
                </li>
                <li class="w-11/12">
                    <div class="flex items-center">
                        <ul>
                            <li class="text-sm text-pink-400">ここにユーザー名６</li>
                            <li class="text-lg">ここにささやき内容６</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

    </div><!-- [name=contents] -->

</x-app-layout>
