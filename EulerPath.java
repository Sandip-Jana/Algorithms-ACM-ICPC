Stack<String> stack = new Stack<>();
        stack.push("JFK");

        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            String top = stack.peek();

            if (!map.containsKey(top) || map.get(top).size() == 0) {
                res.add(0 , stack.pop());
            } else {
                String next = map.get(top).poll();
                stack.push(next);
            }
        }
return res;
