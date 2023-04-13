function hasUnvisited(seen: boolean[], dist: number[]): boolean {
    return seen.some((s, i) => !s && dist[i] < Infinity);
}

function getLowestUnvisited(seen: boolean[], dist: number[]): number {
    let idx = -1;
    let lowestDistance = Infinity;
    for (let i = 0; i < seen.length; ++i) {
        if (seen[i]) {
            continue;
        }

        if (dist[i] < lowestDistance) {
            lowestDistance = dist[i];
            idx = i;
        }
    }

    return idx;

}

export default function djikstra_lift(
    source: number,
    sink: number,
    arr: WeightedAdjacencyList): number[] {

    const seen = new Array(arr.length).fill(false);
    const dists = new Array(arr.length).fill(Infinity);
    const prev = new Array(arr.length).fill(-1);

    dists[source] = 0;

    while (hasUnvisited(seen, dists)) {
        const curr = getLowestUnvisited(seen, dists);
        seen[curr] = true;

        const adjs = arr[curr];

        for (let i = 0; i < adjs.length; ++i) {
            const edge = adjs[i];
            if (seen[edge.to]) {
                continue;
            }
            const dist = dists[curr] + edge.weight;
            if (dist < dists[edge.to]) {
                dists[edge.to] = dist;
                prev[edge.to] = curr;
            }
        }
    }

    const out: number[] = [];
    let curr = sink;

    while (prev[curr] !== -1) {
        out.push(curr);
        curr = prev[curr];
    }

    out.push(source);
    return out.reverse();
}
